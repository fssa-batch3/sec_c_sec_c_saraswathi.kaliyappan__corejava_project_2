Database Desing - SK_Water

Table: Product


| Column           | Data Type     | Constraints   |
|------------------|---------------|---------------|
| Id               | INT           | Primary Key   |
| Name             | VARCHAR(255)  | Not Null      |
| Description      | VARCHAR(1000) |               |
| Price            | DOUBLE        | Not Null      |
| ImageURL         | VARCHAR(255)  |               |
| Capacity         | INT           | Not Null      |
| ManufactureDate  | DATE          |               |

