package com.Collaborative.DSALearningPlatform.Models

/**
 * Represents a link to a technical guide resource.
 * This class is used to encapsulate information about the guide's title and URL.
 */
public class TechGuideLink {

    // Title or name of the technical guide resource
    private String title;

    // URL pointing to the technical guide resource
    private String url;

    /**
     * Constructor to initialize a TechGuideLink with a title and URL.
     *
     * @param title the title or name of the technical guide.
     * @param url   the URL of the technical guide.
     */
    public TechGuideLink(String title, String url) {
        this.title = title;
        this.url = url;
    }

    /**
     * Retrieves the title of the technical guide resource.
     *
     * @return the title of the guide.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the technical guide resource.
     *
     * @param title the title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the URL of the technical guide resource.
     *
     * @return the URL of the guide.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL of the technical guide resource.
     *
     * @param url the URL to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
