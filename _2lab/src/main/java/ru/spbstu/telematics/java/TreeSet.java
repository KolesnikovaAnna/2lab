package ru.spbstu.telematics.java;

import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class TreeSet<T  extends  Comparable<T>> implements Iterable<T> {
    Node<T> root = null;
    int size = 0;
    TreeSet<T> thisList = this;

    void setRoot(Node<T> root) {
        this.root = root;
    }

    public TreeSet(){
        root = null;
        size = 0;
        thisList = this;
    }

    public Iterator<T> iterator(){
        return new TreeSetIteator<T>();
    }

    public Node<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public class Node<T extends  Comparable<? super T>> implements Comparable<T> {

        T data;
        Node<T> left;
        Node<T> right;
        Node<T> next;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
            next=null;
            size++;
        }

        void setLetf(Node<T> left) {
            this.left = left;
        }

        void setRight(Node<T> right) {
            this.right = next;
        }

        public T getData(){return data;}

        public int compareTo(T data){
           return this.data.compareTo(data);
        }
    }


    public class TreeSetIteator<T extends  Comparable<T>> implements Iterator<T>{


        private Node<T> current;
        private int index;


        TreeSetIteator(){
            int a =size;
            current = new Node<T>(null);
            current.next = (Node<T>) root;
            current.next.left = current;
            index=0;
        }

        public boolean hasNext() {
            if(current.next==null){
                return false;
            }
            else {
                return true;
            }
        }

        public boolean hasPrevious() {
            if(current.left==null){
                return false;
            }
            else {
                return true;
            }
        }

        public T next() throws NoSuchElementException {
            if(hasNext()==false){
                throw new NoSuchElementException();
            }
            current=current.next;
            index++;
            return current.data;
        }

        public T previous() throws NoSuchElementException {
            if(hasPrevious()==false){
                throw new NoSuchElementException();
            }
            index--;
            T data=current.data;
            current=current.left;
            return data;
        }


        public void remove() {
            if(hasPrevious()) {
                current.left.next = current.next;
            }
            if(hasNext()) {
                current.next.left = current.left;
            }
            size--;
            if(current==root){
                thisList.root=thisList.root.next;
            }
            if(index!=0){
                index--;
            }
        }

        public int nextIndex(){
            return index+1;
        }
        public int previousIndex(){
            return index-1;
        }

        public void set(T obj){
            current.data=obj;
        }

        public void add(T obj){
            Node<T> newNode = new Node(obj);
            newNode.next = current.next;
            if(hasNext()) {
                current.next.left = newNode;
            }
            current.next = newNode;
            current=current.next;
            size++;
        }
    }


    void add(Node<T> leaf, T key)
    {
        if(root==null){
            root = new Node<T>(key);
        }
       else if(key.compareTo(leaf.getData())<0)//0, если объекты равны, отрицательное число (обычно -1),
            // если первый объект меньше второго, и положительное число (обычно 1), если первый больше
        {
            if(leaf.left!=null)
                add(leaf.left, key);
            else
                leaf.left=new Node<T>(key);
        }
        else if(key.compareTo(leaf.getData())>=0) {
            if(leaf.right!=null)
                add(leaf.right, key);
            else
                leaf.right=new Node<T>(key);
        }
    }

    void remove(T key){
        if(root.data==key){
            if(root.right!=null&&root.right.left==null) {
                root.right.left = root.left;//все, что было слева для корня
                root=root.right;
            }
            else if(root.left!=null&&root.left.right==null){
                root.left.right = root.right;
                root = root.left;
            }
            size--;
        }
        else if(key.compareTo(root.data)<0)//0, если объекты равны, отрицательное число (обычно -1),
        // если первый объект меньше второго, и положительное число (обычно 1), если первый больше
        {
            root = root.left;
            remove(key);
        }
        else if(key.compareTo(root.data)>0) {
            root = root.right;
            remove(key);
        }
    }
    int i = 0;
    int contains(T key){
        if(root.data==key){
            i=1;
            //return i;
        }
        else if(key.compareTo(root.data)<0)//0, если объекты равны, отрицательное число (обычно -1),
        // если первый объект меньше второго, и положительное число (обычно 1), если первый больше
        {
            if(root.left!=null) {
                root = root.left;
                contains(key);
            }
        }
        else if(key.compareTo(root.data)>0) {
           if(root.right!=null) {
               root = root.right;
               contains(key);
           }
        }
        return i;
    }


    class Main {

        public void main(String[] args) {
            TreeSet<Integer> a = new TreeSet<Integer>();
        }
    }
}