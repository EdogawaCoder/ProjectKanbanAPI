# ProjectKanbanAPI

This is a RESTful API built with Spring Boot to manage tasks in a Kanban board.  
これは、カンバンボード内のタスクを管理するために Spring Boot で構築された RESTful API です。

## Features | 機能

- CRUD operations for Kanban tasks  
  タスクの作成・取得・更新・削除が可能
- Automatic ID generation (UUID)  
  自動的に UUID を生成
- Date conversion between String (request) and Date (entity/response)  
  リクエストで受け取った日付文字列を Date 型に変換し、レスポンスでは Date 型で返却
- Custom ModelMapper configuration  
  ModelMapper をカスタム設定で使用
- Global exception handler  
  全体的な例外処理を実装
- CORS restricted to Angular frontend  
  CORS 設定により Angular フロントエンドのみを許可

## API Overview | API概要

**POST /api/v1/kanban/tasks**  
Create a new task  
新しいタスクを作成

**GET /api/v1/kanban/tasks**  
Get all tasks  
全てのタスクを取得

**PUT /api/v1/kanban/tasks/{id}**  
Update task by ID  
ID を指定してタスクを更新

**DELETE /api/v1/kanban/tasks/{id}**  
Delete task by ID  
ID を指定してタスクを削除

## Technologies | 使用技術

- Java 21  
- Spring Boot 3.5  
- Spring Data JPA  
- PostgreSQL  
- ModelMapper  
- Jakarta Bean Validation  
- Swagger OpenAPI (with bilingual annotations)  
- Angular (frontend consuming the API)  
- Optional Docker support coming next

## How to run | 実行方法

1. Clone the repository  
   リポジトリをクローンする

2. Start the application  
   アプリケーションを起動する

```bash
./mvnw spring-boot:run
```

3. Access the Swagger UI (optional)  
   Swagger UI にアクセスする（任意）

```
http://localhost:8082/swagger-ui/index.html
```

## Author | 作成者

Edison (Edogawa)  
Backend Developer in progress  
バックエンド開発者として勉強中  
https://github.com/EdogawaCoder
