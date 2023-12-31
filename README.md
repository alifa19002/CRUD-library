## List Endpoint

| HTTP Method | Endpoint           | Description           |
| ---------- |--------------------|-----------------------|
| GET        | /api/category      | Read All Category     |
| GET        | /api/category/{id} | Get category By ID    |
| POST       | /api/category      | Create New Category   |
| PUT        | /api/category/{id} | Update Category       |
| DELETE     | /api/category/{id} | Delete category by ID |
| GET        | /api/book          | Read All Books        |
| GET        | /api/book/{id}     | Get book By ID        |
| POST       | /api/book          | Create New Book       |
| PUT        | /api/book/{id}     | Update Book           |
| DELETE     | /api/book/{id}     | Delete book by ID     |
| POST       | /api/send-mail     | Send email to         |


```
example usage: http://localhost:8080/api/category
```

## Example
### Post and Put Category
request body raw json:
```json
{
    "name": "action",
    "code": "A019"
}
```
### Post and Put Book
request body raw json:
```json
{
    "title": "Bumi",
    "author": "Tere Liye",
    "publisher": "Mizan",
    "categId": 2,
    "quota" : 10
}
```
### Post Send Email
request body raw json:
```json
{
    "id": 1,
    "emailTo": "receiver@mail.com"
}
```