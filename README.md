# Desafio-Sicred

Faz a leitura um arquivo csv, processa em um serviço ficticio da receita e retorna um csv com dados antigos mais o resultado da validação. 
Passos para gerar o JAR:
1- Abra o terminal na raiz do projeto.
2- Execute o comando:  mvnw  package
Passos para  executar o JAR:
1- Abra o terminal na pasta target que se encontra na raiz do projeto.
2-  Execute o comando,  sendo que o <input-file> deve ser substituido pelo diretorio  e o nome do arquiva a ser processado: java -jar SincronizacaoReceita-2.6.4.jar <input-file>
3- O arquivo utilizado no teste pra realizar o processamento se encontra Desafio-Sicred\src\main\resources\receitaFederal.csv