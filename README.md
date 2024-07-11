A empresa VendeMuito+ Ltda está avaliando um novo sistema de armazenaento de dados dos pedidos efetuados pelo cliente. Inicialmente receberam a presença de um consultor de um famoso banco de dados relacional e que desenvolveu um protótipo baseado no modelo exemplo existente no blog <https://blogs.oracle.com/sql/post/announcing-a-new-sample-schema-customer-orders>.

Aparentemente a empresa gostou do protótipo proposto pelo consultor, mas está um pouco preocupado com a quantidade de dados que deverá ser armazenado e processado, pois estão prevendo um grande crescimento com sua nova linha de produtos.

Para terem um segundo protótipo, você foi contratado para construir um usando um banco de dados documento usando MongoDB. Segue as tarefas que serão executadas:

- Modele a estrutura apresentada no blog acima em formato JSON usando um ou mais coleções (A granularidade da agregação dos dados é uma decisão do projeto)
- Construa um programa básico em Java que faça as 4 operações básicas no Pedido (Create, Read, Update, Delete), além de um programa de busca por exemplo (busca por exemplo recebe um json com alguns dados preenchidos e busca registros similares).
- Escreva um pequeno documento citando vantagens e desvantagens do seu protótipo em relação ao apresentado pelo blog.

Entregue os arquivos gerados (fontes, documento, jsons de exemplos) em um arquivo .zip e suba aqui na ferramenta

```json
{
  "order_id": 1,
  "order_datetime": "2024-07-09T12:34:56Z",
  "order_status": "Shipped",
  "store": {
    "store_id": 301,
    "store_name": "Store 1",
    "web_address": "http://store1.com",
    "physical_address": "123 Store St, City, Country",
    "latitude": 40.7128,
    "longitude": -74.0060,
    "logo": "base64EncodedLogoImageString",
    "logo_mime_type": "image/png",
    "logo_filename": "logo1.png",
    "logo_charset": "UTF-8",
    "logo_last_updated": "2024-07-08"
  },
  "customer": {
    "customer_id": 201,
    "email_address": "customer@example.com",
    "full_name": "John Doe"
  },
  "order_items": [
    {
      "line_item_id": 1,
      "product": {
        "product_id": 101,
        "product_name": "Product 1",
        "unit_price": 19.99,
        "product_details": "Detailed description of Product 1",
        "product_image": "base64EncodedImageString",
        "image_mime_type": "image/jpeg",
        "image_filename": "product1.jpg",
        "image_charset": "UTF-8",
        "image_last_updated": "2024-07-08"
      },
      "quantity": 2
    },
    {
      "line_item_id": 2,
      "product": {
        "product_id": 102,
        "product_name": "Product 2",
        "unit_price": 29.99,
        "product_details": "Detailed description of Product 2",
        "product_image": "base64EncodedImageString",
        "image_mime_type": "image/jpeg",
        "image_filename": "product2.jpg",
        "image_charset": "UTF-8",
        "image_last_updated": "2024-07-08"
      },
      "quantity": 1
    }
  ]
}
```
