public class ProductManager {
    private Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.saveProduct(product);
    }
    public Product[] getProducts() {
        Product[] all = repository.findAll();
        return all;
    }
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                result[result.length -1] = product;// "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
