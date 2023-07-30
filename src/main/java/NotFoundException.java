public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Продукта с id "+ id + " не найдено");
    }
}
