package com.atguigu.designmethods.IteratorPattern;

public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public int getLength() {
        return last;
    }

    public void addBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    @Override
    public Iterator createIterator() {
        return new BookShelfIterator(this);
    }
}

 class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
