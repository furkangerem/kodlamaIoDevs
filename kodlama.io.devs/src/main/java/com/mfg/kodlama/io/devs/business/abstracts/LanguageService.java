package com.mfg.kodlama.io.devs.business.abstracts;

import java.util.List;

import com.mfg.kodlama.io.devs.entities.Language;

public interface LanguageService {

	List<Language> getAll();
	Language getById(int id) throws Exception;
	void create(Language language) throws Exception;
	void update(Language language, int id) throws Exception;
	void delete(int id) throws Exception;
}