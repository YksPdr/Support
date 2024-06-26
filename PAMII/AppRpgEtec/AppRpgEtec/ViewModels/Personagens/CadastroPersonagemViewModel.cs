using AppRpgEtec.Models;
using AppRpgEtec.Models.Enuns;
using AppRpgEtec.Services.Personagens;
using System.Collections.ObjectModel;
using System.Windows.Input;

namespace AppRpgEtec.ViewModels.Personagens
{
    [QueryProperty("PersonagemSelecionadoId", "pId")]
    public class CadastroPersonagemViewModel : BaseViewModel
    {
        private PersonagemService pService;
        public ICommand SalvarCommand { get; }
        public ICommand CancelarCommand { get; set; }

        public CadastroPersonagemViewModel()
        {
            string token = Preferences.Get("UsuarioToken", string.Empty);
            pService = new PersonagemService(token);
            _ = ObterClasses();

            SalvarCommand = new Command(async () => { await SalvarPersonagem(); }, () => ValidarCampos());
            CancelarCommand = new Command(async => CancelarCadastro());
        }

        private async void CancelarCadastro()
        {
            await Shell.Current.GoToAsync("..");
        }

        #region Attributes/Properties
        private int id;
        private string nome;
        private int pontosVida;
        private int forca;
        private int defesa;
        private int inteligencia;
        private int disputas;
        private int vitorias;
        private int derrotas;

        public int Id
        {
            get => id;
            set
            {
                id = value;
                OnPropertyChanged(nameof(Id));//Informa mundaça de estado para a View para ViewModel ou vice-versa de acordo com a herança da BaseViewModel
            }
        }

        public string Nome
        {
            get => nome;
            set
            {
                nome = value;
                OnPropertyChanged(nameof(Nome));
                ((Command)SalvarCommand).ChangeCanExecute();
            }
        }

        public int PontosVida
        {
            get => pontosVida;
            set
            {
                pontosVida = value;
                OnPropertyChanged(nameof(PontosVida));
                OnPropertyChanged(nameof(CadastroHabilitado));
            }
        }

        public int Forca
        {
            get => forca;
            set
            {
                forca = value;
                OnPropertyChanged(nameof(Forca));
            }
        }

        public int Defesa
        {
            get => defesa;
            set
            {
                defesa = value;
                OnPropertyChanged(nameof(Defesa));
            }
        }

        public int Inteligencia
        {
            get => inteligencia;
            set
            {
                inteligencia = value;
                OnPropertyChanged(nameof(Inteligencia));
            }
        }

        public int Disputas
        {
            get => disputas;
            set
            {
                disputas = value;
                OnPropertyChanged(nameof(Disputas));
            }
        }

        public int Vitorias
        {
            get => vitorias;
            set
            {
                vitorias = value;
                OnPropertyChanged(nameof(Vitorias));
            }
        }

        public int Derrotas
        {
            get => derrotas;
            set
            {
                derrotas = value;
                OnPropertyChanged(nameof(Derrotas));
            }
        }

        private ObservableCollection<TipoClasse> listaTiposClasse;
        public ObservableCollection<TipoClasse> ListaTiposClasse
        {
            get { return listaTiposClasse; }
            set
            {
                if (value != null)
                {
                    listaTiposClasse = value;
                    OnPropertyChanged(nameof(ListaTiposClasse));
                }
            }
        }

        private TipoClasse tipoClasseSelecionado;
        public TipoClasse TipoClasseSelecionado
        {
            get { return tipoClasseSelecionado; }
            set
            {
                if (value != null)
                {
                    tipoClasseSelecionado = value;
                    OnPropertyChanged(nameof(TipoClasseSelecionado));
                }
            }
        }

        private string personagemSelecionadoId;//CTRL + R,E
        public string PersonagemSelecionadoId
        {
            set
            {
                if (value != null)
                {
                    personagemSelecionadoId = Uri.UnescapeDataString(value);
                    CarregarPersonagem();
                }
            }
        }

        public bool CadastroHabilitado
        {
            get
            {
                return (PontosVida > 0);
            }
        }
        #endregion

        #region Methods
        public async Task ObterClasses()
        {
            try
            {
                ListaTiposClasse = new ObservableCollection<TipoClasse>();
                ListaTiposClasse.Add(new TipoClasse() { Id = 1, Descricao = "Cavaleiro" });
                ListaTiposClasse.Add(new TipoClasse() { Id = 2, Descricao = "Mago" });
                ListaTiposClasse.Add(new TipoClasse() { Id = 3, Descricao = "Clerigo" });
                OnPropertyChanged(nameof(ListaTiposClasse));
            }
            catch (Exception ex)
            {
                await Application.Current.MainPage
                    .DisplayAlert("Ops", ex.Message + " Detalhes: " + ex.InnerException, "Ok");
            }
        }

        public async Task SalvarPersonagem()
        {
            try
            {
                Personagem model = new Personagem()
                {
                    Nome = nome,
                    PontosVida = pontosVida,
                    Defesa = defesa,
                    Derrotas = derrotas,
                    Disputas = disputas,
                    Forca = forca,
                    Inteligencia = inteligencia,
                    Vitorias = vitorias,
                    Id = id,
                    Classe = (ClasseEnum)tipoClasseSelecionado.Id
                };

                if (model.Id == 0)
                    await pService.PostPersonagemAsync(model);
                else
                    await pService.PutPersonagemAsync(model);

                await Application.Current.MainPage.DisplayAlert("Mensagem", "Dados salvos com sucesso!", "Ok");
                await Shell.Current.GoToAsync(".."); //Remove a página atual da pilha de páginas                 
            }
            catch (Exception ex)
            {
                await Application.Current.MainPage.DisplayAlert("Ops", ex.Message + " Detalhes: " + ex.InnerException, "Ok");
            }
        }

        public async void CarregarPersonagem()
        {
            try
            {
                Personagem p = await pService.GetPersonagemAsync(int.Parse(personagemSelecionadoId));

                Nome = p.Nome;
                PontosVida = p.PontosVida;
                Defesa = p.Defesa;
                Derrotas = p.Derrotas;
                Disputas = p.Disputas;
                Forca = p.Forca;
                Inteligencia = p.Inteligencia;
                Vitorias = p.Vitorias;
                Id = p.Id;

                TipoClasseSelecionado = ListaTiposClasse.FirstOrDefault(tClasse => tClasse.Id == (int)p.Classe);
            }
            catch (Exception ex)
            {
                await Application.Current.MainPage.DisplayAlert("Ops", ex.Message + " Detalhes: " + ex.InnerException, "Ok");
            }
        }

        public bool ValidarCampos()
        {
            return !string.IsNullOrEmpty(Nome) && CadastroHabilitado && Forca != 0 && Defesa != 0;
        }
        #endregion
    }
}