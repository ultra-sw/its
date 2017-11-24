package ru.ultrasoftware.its.domain;
import ru.ultrasoftware.its.domain.Ticket;
import ru.ultrasoftware.its.domain.Article;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TicketCreate {

    @JsonProperty("Ticket")
    private Ticket ticket = new Ticket();
    @JsonProperty("Article")
    private Article article = new Article();

    public Article getArticle() {
        return article;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
