package com.WoodPecker.login.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "flashcards")
public class FlashCard implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
    private String question;
    private String answer;
    private String category;
    private Difficulty difficulty = null;
    private Date timeSkip = new Date();
    private int numberReview = 0;
    private User idUser;

    public FlashCard() {}
    
  
    public FlashCard(String id, String question, String answer, String category, Difficulty difficulty, Date timeSkip,
			int numberReview, User idUser) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.category = category;
		this.difficulty = difficulty;
		this.timeSkip = timeSkip;
		this.numberReview = numberReview;
		this.idUser = idUser;
	}



	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Date getTimeSkip() {
        return timeSkip;
    }

    public void setTimeSkip(Date timeSkip) {
        this.timeSkip = timeSkip;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }


	public User getIdUser() {
		return idUser;
	}


	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}


	@Override
	public int hashCode() {
		return Objects.hash(answer, category, difficulty, id, idUser, numberReview, question, timeSkip);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlashCard other = (FlashCard) obj;
		return Objects.equals(answer, other.answer) && Objects.equals(category, other.category)
				&& difficulty == other.difficulty && Objects.equals(id, other.id)
				&& Objects.equals(idUser, other.idUser) && numberReview == other.numberReview
				&& Objects.equals(question, other.question) && Objects.equals(timeSkip, other.timeSkip);
	}
	
	

}
