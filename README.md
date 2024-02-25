## Руководство по запуску
### Запуск приложения с помощью файла docker-compose.yml (Dockerfile) (frontendApp + backendApp + postgres)
- Клонируем проект на свой ПК [github.com/ArtemMaluev/DiplomaWork_cloud_storage.git](https://github.com/ArtemMaluev/DiplomaWork_cloud_storage.git);
- Запускаем приложение Docker Desktop;
- Открываем проект в среде разработки IntelliJ IDEA;
- Собрать jar файл можно двумя способами:
    - Запускаем терминал в папке  `/DiplomaWork_cloud_storage` и собираем jar архив с нашим Spring REST приложением с помощью команд:
      ```mvn clean package -Dskiptests``` и ```mvn clean package -Dmaven.test.skip```;
    - Во вкладке Maven активируем иконку `Togger 'Skip Tests' Mode`, в катлоге `Lifecycle` активировать команды `clear` и `package`;
- После успешной сборки в папке будет находиться jar файл:`DiplomaWork_cloud_storage-0.0.1-SNAPSHOT.jar`;
- В терминале выполнить команду по сборке images и containers: ```docker-compose up```;
- В докере запустятся 3 приложения:
    - backend-server, Java 11 на порту: ```http://localhost:8888```;
    - frontend-client, Node 15 на порту: ```http://localhost:8080```;
    - database-server на порту: ```http://localhost:3306```;
- Запустить тесты можно:
    - Через терминал командой `mvn test`;
    - Во вкладке Maven отключаем иконку `Togger 'Skip Tests' Mode`, в катлоге `Lifecycle` активировать команды `test`;


### Для тестирования frontend + backend + mysql нужно авторизовать пользователя:
- Отправить POST запрос `http://localhost:8888/login`
- JSON -> `{
  "login": "User",
  "password": "user1234"
  }`

### Если в Базе Данных mysql нет этого пользователя, то нужно создать пользователя
- Отправить POST запрос `http://localhost:8888/user/register`
- JSON -> `{
  "login": "User",
  "password": "user1234"
  }`

### Завершение работы
- Выход из приложения: в терминале нажать "Ctrl+C"
- Удаление Docker контейнера: ```docker-compose down```


## База данных

В приложении используется СУБД MySQL, со следующими настройками:

`spring.datasource.url=jdbc:mysql://localhost:3306/mysqlDataBase?createDatabaseIfNotExist=true`

`spring.datasource.username=root`

`spring.datasource.password=root`

В программе используется 3 таблицы БД:

* user_entity - для хранения пользователей. Поля id, login, password, role.
* file_entity - для хранения файлов. Поля id, file_name, file_type, file_data, hash, size, user_id
* user_entity_roles - для сопостановления пользователя и ролей. Поля id, roles, user_entity_id.