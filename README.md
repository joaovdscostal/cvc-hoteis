# Hotel Booking API - Teste Back-end Developer

Este projeto consiste na implementação de uma API Rest em Java com o framework Spring Boot para consultar hotéis disponíveis. O teste envolve o desenvolvimento de duas APIs: uma para obter a lista de hotéis disponíveis em uma cidade específica e outra para obter detalhes de um hotel com base no seu ID.

## Descrição das APIs

### API - 1

**Endpoint:** /hotels/avail/{ID_da_Cidade}  
**Método:** GET

A API responde aos seguintes ID_da_Cidade:
1. 1032 (Porto Seguro)
2. 7110 (Rio de Janeiro)
3. 9626 (São Paulo)

**Exemplo de resposta:**
```json
URL: /hotels/avail/1032
// Response
[{
  "id": 1,
  "name": "Hotel Teste 1",
  "cityCode": 1032,
  "cityName": "Porto Seguro",
  "rooms": [
    {
      "roomID": 0,
      "categoryName": "Standard",
      "price": {
        "adult": 1372.54,
        "child": 848.61
      }
    }
  ]
}]
```

### API - 2

**Endpoint:** /hotels/{ID_Do_Hotel}  
**Método:** GET

**Exemplo de resposta:**
```json
URL: /hotels/1
// Response
[{
  "id": 1,
  "name": "Hotel Teste 1",
  "cityCode": 1032,
  "cityName": "Porto Seguro",
  "rooms": [
    {
      "roomID": 0,
      "categoryName": "Standard",
      "price": {
        "adult": 1372.54,
        "child": 848.61
      }
    }
  ]
}]
```
