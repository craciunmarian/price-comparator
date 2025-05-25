# price-comparator

The features I managed to implement are best discounts, a bit of price history and product value per unit.

The project has 3 models Price, Discount and Product in accordance with the fields from the CSV files. 

One DTO Discounted Product used to connect the Price/Product models with Discount to calculate the discounted price and new value pe unit.

Services and controllers to manage BestDiscounts, PriceHistory and ProductList.

The data is stored in a repository PriceDataRepository loaded using a CSV parser from the OpenCSV library.

All dependencies should be included.
Running the project locally and navigating to
http://localhost:8080/price-history/{productId}(e.g. P062) : highlights the price history of the product
http://localhost:8080/bestDiscounts/list : lists all discounted products sorted by percentage
http://localhost:8080/products/list : lists all available products

The datasets are the ones provided in the pdf file.
