"# cadastrousuariosapi" 

consumo:
- http://localhost:8080/cargos - GET : Consulta cargos cadastrados
- http://localhost:8080/cargos/{id} - GET : Consulta cargos cadastrados por codigo
- http://localhost:8080/cargos - POST : Salva cargo
- http://localhost:8080/cargos/{id} - PUT : Atualiza cargo
- http://localhost:8080/cargos/{id} - DELETE : Remove cargo

- http://localhost:8080/perfis - GET : Consulta perfis cadastrados
- http://localhost:8080/perfis/{id} - GET : Consulta perfil cadastrados por codigo
- http://localhost:8080/perfis - POST : Salva perfil
- http://localhost:8080/perfis/{id} - PUT : Atualiza perfil
- http://localhost:8080/perfis/{id} - DELETE : Remove perfil

- http://localhost:8080/usuarios - GET : Consulta usuarios cadastrados
- http://localhost:8080/usuarios/{id} - GET: Consulta usuarios cadastrados por codigo
- http://localhost:8080/usuarios - POST : Salva usuario
- http://localhost:8080/usuarios/{id} - PUT : Atualiza usuario
- http://localhost:8080/usuarios/{id} - DELETE : Remove usuario
- http://localhost:8080/usuarios/{id}/cargo/{cargoId} - POST : insere cargo para usuario
- http://localhost:8080/usuarios/{id}/perfil/{perfilId} - POST : insere perfil para usuario

Projeto utiliza Autenticação com Spring Security.
usuario: desafio
password: s3nh4

- Para utilisar é necessáio informar Basic Auth


