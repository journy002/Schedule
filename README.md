### 1. 일정 관리 API 명세서

| 기능             | HTTP Method | Endpoint           | 요청 데이터 (Request Body)                                     | 응답 데이터 (Response Body) |
|----------------|------------|-------------------|------------------------------------------------|--------------------------|
| 일정 생성      | `POST`     | `/schedules`      | `{ "title": "회의 준비", "author": "홍길동", "password": "1234" }` | `"일정이 성공적으로 등록되었습니다."` |
| 전체 일정 조회 | `GET`      | `/schedules`      | 없음                                           | `[ { "id": 1, "title": "회의 준비", "author": "홍길동", "updatedAt": "2024-02-02T12:00:00" } ]` |
| 선택 일정 조회 | `GET`      | `/schedules/{id}` | 없음                                           | `{ "id": 1, "title": "회의 준비", "author": "홍길동", "updatedAt": "2024-02-02T12:00:00" }` |

### 2. ERD 다이어그램

┌───────────┬──────────────┬──────┬──────┬───────────────────────┬─────────────────────────────┐
│   Field   │     Type     │ Null │ Key  │       Default         │            Extra            │
├───────────┼──────────────┼──────┼──────┼───────────────────────┼─────────────────────────────┤
│ id        │ INT(11)      │ NO   │ PRI  │ AUTO_INCREMENT        │                             │
│ title     │ VARCHAR(255) │ NO   │      │ NULL                  │                             │
│ author    │ VARCHAR(100) │ NO   │      │ NULL                  │                             │
│ password  │ VARCHAR(255) │ NO   │      │ NULL                  │                             │
│ created_at│ TIMESTAMP    │ NO   │      │ CURRENT_TIMESTAMP     │                             │
│ updated_at│ TIMESTAMP    │ NO   │      │ CURRENT_TIMESTAMP     │ ON UPDATE CURRENT_TIMESTAMP │
└───────────┴──────────────┴──────┴──────┴───────────────────────┴─────────────────────────────┘

### 3. SQL 파일

CREATE TABLE schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
