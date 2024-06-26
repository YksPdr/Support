﻿#nullable enable

namespace AppRpgEtec.Models
{
    public class Usuario
    {
        public int Id { get; set; } //Atalho para propridade (PROP + TAB)
        public string Username { get; set; } = string.Empty;
        public string PasswordString { get; set; } = string.Empty;
        public string Perfil { get; set; } = string.Empty;
        public string Token { get; set; } = string.Empty;
        public string Email { get; set; } = string.Empty;

        public byte[]? Foto { get; set; }
        public double? Latitude { get; set; }
        public double? Longitude { get; set; }
    }
}