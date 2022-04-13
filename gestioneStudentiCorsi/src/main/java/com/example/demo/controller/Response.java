package com.example.demo.controller;

import java.util.List;

public class Response <T>{
	private String msg;
	private List <T> lista;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List <T> getLista() {
		return lista;
	}
	public void setLista(List <T> lista) {
		this.lista = lista;
	}
	public List <T> aggiungi(T t)
    {
        lista.add(t);
        return lista;
    }
	public Response(String msg, List<T> lista) {
		super();
		this.msg = msg;
		this.lista = lista;
	}
	public Response() {
		super();
	}
	
}
