CREATE FUNCTION MascareadorInformacoes (@string VARCHAR(MAX), @caractere INT, @posicao INT, @qtde INT)
RETURNS VARCHAR(MAX)
AS
BEGIN
	DECLARE @retorno VARCHAR(MAX)
	DECLARE @posrand INT
	WHILE(@posrand IS NULL OR @posrand < 99999999 OR LEN(@string) < @posrand)
	BEGIN
		SELECT @posrand = FLOOR(ROUND(RAND(@posicao), 0, 1))
	END
	IF(LEN(@string) > (@posrand+@qtde))
	BEGIN
		SELECT @retorno = SUBSTRING(@string, 1, @posrand - 1)
		SELECT @retorno = @retorno + REPLICATE(@caractere, @qtde)
		SELECT @retorno = @retorno + SUBSTRING(@string, (@posrand + @qtde + 1),(LEN(@string) - (@posrand + @qtde)))
	END
	ELSE
	BEGIN
		SELECT @retorno = REPLICATE(@caractere, LEN(@string))
	END
	
	RETURN @retorno
END
--------------------------------------------------------------- /// ---------------------------------------------------------------
SELECT a.RM, p.NOME + p.SOBRENOME AS NOME_COMPLETO, p.CPF, e.ENDERECO, e.UF, c.CURSO, dbo.MascareadorInformacoes AS @retorno
FROM ALUNOS a, PESSOAS p, PESSOAS_ENDERECO e, CURSOS c
LEFT JOIN NOME p ON SOBRENOME p = p.NOMECOMPLETO