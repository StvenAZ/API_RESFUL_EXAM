package com.example.api_resful_exam;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Articulo {
    @SerializedName("section")
    private String section;

    @SerializedName("publication_id")
    private String publicationId;

    @SerializedName("title")
    private String title;

    @SerializedName("doi")
    private String doi;

    @SerializedName("abstract")
    private String abstractText;

    @SerializedName("date_published")
    private String datePublished;

    @SerializedName("galeys")
    private List<Galley> galeys;

    // Getters y setters
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

    public String getPublicationId() { return publicationId; }
    public void setPublicationId(String publicationId) { this.publicationId = publicationId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDoi() { return doi; }
    public void setDoi(String doi) { this.doi = doi; }

    public String getAbstractText() { return abstractText; }
    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }

    public String getDatePublished() { return datePublished; }
    public void setDatePublished(String datePublished) { this.datePublished = datePublished; }

    public List<Galley> getGaleys() { return galeys; }
    public void setGaleys(List<Galley> galeys) { this.galeys = galeys; }

    // Método para obtener la URL del PDF
    public String getPdfUrl() {
        if (galeys != null) {
            for (Galley galley : galeys) {
                if ("PDF".equals(galley.getLabel())) {
                    return galley.getUrlViewGalley();
                }
            }
        }
        return null;
    }

    // Clase interna Galley
    public static class Galley {
        @SerializedName("label")
        private String label;

        @SerializedName("UrlViewGalley")
        private String urlViewGalley;

        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }

        public String getUrlViewGalley() { return urlViewGalley; }
        public void setUrlViewGalley(String urlViewGalley) { this.urlViewGalley = urlViewGalley; }
    }
}