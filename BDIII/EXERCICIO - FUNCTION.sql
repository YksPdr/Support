CREATE FUNCTION VerificarAluno (@n1 FLOAT, @n2 FLOAT, @n3 FLOAT, @n4 FLOAT)
RETURNS VARCHAR(20)
AS
BEGIN 
	DECLARE @media FLOAT, @situacao VARCHAR(20)
	DECLARE @media = (@n1 + @n2 + @n3 + @n4) / 4
	IF @media < 30
	BEGIN
		SELECT @situacao = 'reprovado'
	END
	ELSE 
	BEGIN
		IF @media >= 30 AND @media < 55
		BEGIN
			SELECT @situacao = 'recuperacao'
		END
	END
	ELSE
	BEGIN
		IF @media >= 55 AND @media < 85
		BEGIN
			SELECT @situacao = 'aprovado'
		END
	END
	ELSE
	BEGIN
		SELECT @situacao = 'aprovado com louvor'
	END
	RETURN @situacao
END

--------------------------------------------------------------- /// ---------------------------------------------------------------

SELECT Alunos.RM, Alunos.Nome, Materias.Curso, Materias.Sigla, Mencoes.Materia, dbo.VerificarAluno(@n1, @n2, @n3, @n4) AS @situacao
FROM Alunos
INNER JOIN Cursos ON Alunos.RM = Cursos.RM
INNER JOIN Materias ON Cursos.Sigla = Materias.Sigla