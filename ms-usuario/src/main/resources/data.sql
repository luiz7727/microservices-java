-- 6 registros de usuário

INSERT INTO TB_USUARIO (NOME,EMAIL,SENHA) VALUES ('Carlos','carlos@gmail.com','1234');
INSERT INTO TB_USUARIO (NOME,EMAIL,SENHA) VALUES ('Robson','robson@gmail.com','12345');
INSERT INTO TB_USUARIO (NOME,EMAIL,SENHA) VALUES ('Marina','marina@gmail.com','123456');
INSERT INTO TB_USUARIO (NOME,EMAIL,SENHA) VALUES ('Jose','jose@gmail.com','1234567');
INSERT INTO TB_USUARIO (NOME,EMAIL,SENHA) VALUES ('Pedro','pedro@gmail.com','12345678');
INSERT INTO TB_USUARIO (NOME,EMAIL,SENHA) VALUES ('Rafaella','rafaella@gmail.com','123456789');

-- 6 registros de posts

INSERT INTO TB_POST(NOME,DESCRICAO,CONTEUDO,USUARIO_ID)
VALUES ('"Malabarismos da Maternidade: Como Equilibrar Trabalho e Cuidados com os Filhos',
        'Desde a organização do tempo até dicas para manter a produtividade, este artigo oferece insights valiosos para as mães malabaristas.',
        'Sugestões de aplicativos e ferramentas para gerenciamento de tempo.',2);
INSERT INTO TB_POST(NOME,DESCRICAO,CONTEUDO,USUARIO_ID)
VALUES ('Receitas Infalíveis para Lanches Saudáveis: Nutrindo Mães e Filhos',
                                                             'Descubra neste post receitas deliciosas e nutritivas que podem ser preparadas rapidamente para satisfazer tanto o paladar exigente das crianças quanto as necessidades nutricionais das mães. Uma abordagem saborosa para manter todos bem alimentados!','Receitas de lanches saudáveis, rápidos e fáceis.',5);
INSERT INTO TB_POST(NOME,DESCRICAO,CONTEUDO,USUARIO_ID)
VALUES ('Círculos de Apoio: Como Encontrar e Construir sua Tribo Materna','Exploraremos a importância de ter uma rede de apoio durante a jornada da maternidade. Este post oferece dicas sobre como encontrar e construir um círculo de apoio sólido, compartilhando histórias inspiradoras de amizades maternas duradouras.','Sugestões para encontrar grupos de mães locais ou online.',3);

INSERT INTO TB_POST(NOME,DESCRICAO,CONTEUDO,USUARIO_ID)
VALUES ('A Arte da Autocompaixão Materna: Cuidando de Si para Cuidar dos Outros',' Este post aborda a importância da autocompaixão na maternidade e oferece práticas simples para as mães incorporarem o autocuidado em suas rotinas agitadas, promovendo uma abordagem mais gentil consigo mesmas.','Exercícios práticos de autocompaixão.',3);

INSERT INTO TB_POST(NOME,DESCRICAO,CONTEUDO,USUARIO_ID)
VALUES ('Desconstruindo o Mito da Mãe Perfeita: Aceitando a Imperfeição com Amor','Explore a pressão social em torno da perfeição na maternidade e como as mães podem abraçar a imperfeição com amor e aceitação. Este post oferece uma visão realista da maternidade e dicas para lidar com a pressão de ser uma "mãe perfeita".','Reflexões sobre a pressão social e as expectativas irreais.',1);

INSERT INTO TB_POST(NOME,DESCRICAO,CONTEUDO,USUARIO_ID)
VALUES ('Brincadeiras Criativas: Como Estimular o Desenvolvimento dos Filhos de Maneira Divertida','Este post oferece ideias criativas de brincadeiras que não apenas entretêm, mas também promovem o desenvolvimento saudável das crianças. Mães encontrarão inspiração para transformar momentos comuns em oportunidades educativas e divertidas.','Lista de brincadeiras que estimulam diferentes aspectos do desenvolvimento infantil.',1);

-- 6 registros de comentario

INSERT INTO TB_COMENTARIO(NOME, USUARIO_ID,POST_ID) values ('Post Excelente, recomendo demais',2,1);
INSERT INTO TB_COMENTARIO(NOME, USUARIO_ID,POST_ID) values ('Essas receitas são incríveis! Meu filho é tão exigente, mas acho que esses lanches vão conquistá-lo. Mal posso esperar para experimentar!',1,1);
INSERT INTO TB_COMENTARIO(NOME, USUARIO_ID,POST_ID) values ('Encontrar uma tribo materna é tão essencial. Compartilhar histórias e experiências com outras mães torna essa jornada muito mais fácil. Alguém mais à procura de um círculo de apoio?',5,1);
INSERT INTO TB_COMENTARIO(NOME, USUARIO_ID,POST_ID) values ('Uau, esse post é exatamente o que eu precisava ler hoje. É tão fácil se perder na pressão de ser a mãe perfeita. Estou aprendendo a abraçar a imperfeição!',4,1);
INSERT INTO TB_COMENTARIO(NOME, USUARIO_ID,POST_ID) values ('Essas ideias de brincadeiras são tão divertidas! Adoro a ideia de tornar o aprendizado algo lúdico. Vou tentar algumas dessas com meus filhos este fim de semana!',3,1);
INSERT INTO TB_COMENTARIO(NOME, USUARIO_ID,POST_ID) values ('Bom Demais',1,1);