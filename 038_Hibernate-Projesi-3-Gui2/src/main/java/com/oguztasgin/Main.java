package com.oguztasgin;

import com.oguztasgin.utils.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory().openSession();
	}
}
