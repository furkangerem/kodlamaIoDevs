package com.mfg.kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mfg.kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import com.mfg.kodlama.io.devs.entities.Language;

@Repository
public class LanguageRepositoryInMemory implements LanguageRepository {

	List<Language> languages;

	public LanguageRepositoryInMemory() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "C#"));
		languages.add(new Language(3, "Python"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) throws Exception {
		for (Language language : languages) {
			if (language.getId() == id) {
				return language;
			}
		}
		throw new Exception("Böyle bir kayıt bulunamadı");
	}

	@Override
	public void create(Language language) {
		languages.add(language);
	}

	@Override
	public void update(Language language, int id) throws Exception {
		Language tempLanguage = getById(language.getId());
		tempLanguage.setName(language.getName());
	}

	@Override
	public void delete(int id) throws Exception {
		Language tempLanguage = getById(id);
		languages.remove(tempLanguage);
	}
}