package com.atguigu.designmethods.IteratorPattern;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.addBook(new Book("The Pragmatic Programmer"));
        bookShelf.addBook(new Book("Design Patterns"));
        bookShelf.addBook(new Book("Clean Code"));
        bookShelf.addBook(new Book("Refactoring"));

        Iterator iterator = bookShelf.createIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
