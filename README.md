# banco-de-dados-atividade-2

A atividade foi feita usando a linguagem Java, através da Eclipse IDE 2019-03.

1 - Para compilar, o projeto deve ser importando no eclipse, e então o driver do PostgreSQL deve ser referenciado no projeto clicando com botão direito no nome, e acessando o caminho Build Path -> Add External Archives, assim o driver deve ser selecionado na pasta em que se encontra e o procedimento deve ser concluído.

2 - Para o funcionamento correto do programa, o arquivo "DataBase.java" deve ser alterado para adequar as informações de conexão ao banco de dados que estiver sendo utilizado, por padrão está definido da seguinte forma:

    String stringDeConexao = "jdbc:postgresql://localhost:5432/empresa";
		String usuario = "postgres";
		String senha = "postgres";
