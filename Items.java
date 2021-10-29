package org.launchcode.Songs4Soldiers.models;

public class Items {

    public class Item {

        private Product id;

        private int quantity;

        private String color;

        private String size;

        private double price;

        public Item(Product id, int quantity, String color, String size, double price) {
            this.id = id;
            this.quantity = quantity;
            this.color = color;
            this.size = size;
            this.price = price;
        }

        public Item() {
        }

        public Product getId() {
            return id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public double getPrice() {
            return price;
        }
    }
}
