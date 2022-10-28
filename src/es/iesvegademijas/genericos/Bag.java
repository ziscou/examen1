package es.iesvegademijas.genericos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Bag<T> implements Comparable<T> {
	ArrayList<T> bolsa;
	

	public Bag() {
		this.bolsa = new ArrayList<>();
	}
	public void add(T elem) {
		bolsa.add(elem);
	}
	public void add(T elem, int n) {
		for (int i=0;i<n;i++) {
			bolsa.add(elem);
		}
	}
	public int countGet(T elem) {
		int num= 0;
		for (T t : bolsa) {
			t.equals(elem);
		}
		return num;
	}
	public void remove(T elem) {
		bolsa.removeIf(e -> e.equals(elem));
	}
	public int Size() {

		return bolsa.size();
	}
	

	@Override
	public String toString() {
		return "Bag [bolsa=" + bolsa + "]";
	}
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
