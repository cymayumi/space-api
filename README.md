# space-api

A API Rest foi elaborada utilizando Java 11, Spring Boot e banco de dados H2. São três endpoints, um responsável pelo pouso, um pelo movimento da sonda e 
outro para mostrar informações de uma determinada sonda.<br>

Foram feitos alguns tratamentos para que não seja permitido colocar inputs inválidos (Ex.: um movimento da sonda que não seja L, M ou R). 
Também foi tratada a impossibilidade da sonda se mover fora da área do planeta (5x5).<br>

Alguns testes unitários foram feitos com JUnit e Mockito.<br><br>

***Pousar sonda***<br>
POST: http://localhost:8080/spacecrafts
<br>
Exemplo de request body:<br>
{
    "planet": "Terra",
    "spacecraftList": [
        {
            "nameSpacecraft": "SondaA",
            "positionH": 1,
            "positionV": 2,
            "positionFront": "N"
        },
        {
            "nameSpacecraft": "SondaB",
            "positionH": 3,
            "positionV": 3,
            "positionFront": "E"
        }
    ]
}
<br><br>
***Mover sonda***<br>
PUT: http://localhost:8080/spacecrafts
<br>
Exemplo de request body:<br>
{
    "nameSpacecraft": "SondaA",
    "move": "LMLMLMLMM"
}
<br><br>
***Dados sonda***<br>
GET: http://localhost:8080/spacecrafts/{nome_da_sonda}<br>
Exemplo de chamanda: http://localhost:8080/spacecrafts/SondaA
