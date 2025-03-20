package com.app.finanace.service;

import com.app.finanace.model.Cibil;

public interface CibilService {

	 public void saveCibil(Cibil c);

	public Cibil findByCibilId(int cibilId);

}
