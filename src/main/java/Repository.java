public class Repository {
    protected Product[] products = new Product[0];

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] saveProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
        return tmp;
    }

    public Product[] saveProductAlreadyExist(Product product) {
        Product[] tmp = new Product[products.length + 1];
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException("ID already exists ");
        }
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
        return tmp;
    }


    public Product[] findAll() {
        return products;
    }


    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        if (findById(id) == null) {
            throw new NotFoundException("ID doesn't exists: " + id);
        }
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }


}
