# Evento
Gerenciador do Evento

Para compilar e executar o programa selecione a pasta src deste repositório, dentro dela então todas as classes do sistema, basta criar um projeto em Java utilizando a ferramenta Eclipse
IDE, criar as classes com o mesmo nome e colar o código de cada classe correspondente.

A classe inicial é o "Sistema", nela você escolhe entre gerenciar as informações dos participantes, salas ou espaços de café. Também possui a opção "Processar Dados" que irá 
analisar todos os dados cadastrados (Cadastre todos os dados antes de utilizar esta opção e use-a apenas uma vez, caso contrário terá que deletar as informações e cadastrá-las 
novamente). Os participantes serão atribuídos às salas e aos espaços de café conforme o número de participantes e separados por etapa.  As salas e espaços de café passarão à 
conter os participantes que utilizarão esses locais.

A classe "TelaParticipante" possui o CRUD (Create (Criação), Read (Ler), Update (Atualizar) e Delete (Destruir)) dos participantes, com ele será possível realizar o cadastro, a
consulta, atualizar informações e apagar participantes.

A classe "TelaSala" possui o CRUD das salas, com ele será possível realizar o cadastro, a consulta, atualizar informações e apagar as salas do evento.

A classe "TelaEspaco" possui o CRUD dos espaços de café, com ele será possível realizar o cadastro, a consulta, atualizar informações e apagar dos espaços de café.

Aos cadastrar os dados lembre-se de não atribuir IDs iguais, não importando se são números ou letras.

Todos os dados são salvos em arquivos de texto para garantir a permanência de dados.

Após cadastrar todos os dados volte a tela inicial do Sistema e pressione o botão de Processar Dados, agora todos os participantes estão atribuídos à uma sala e espaço e vice-versa. Para consultar os dados basta ir na opção de gerenciar, informar o ID da Sala, Espaço ou Participante e clicar em Buscar.
