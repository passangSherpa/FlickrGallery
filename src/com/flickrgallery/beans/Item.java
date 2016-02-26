
package com.flickrgallery.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "title",
    "link",
    "media",
    "date_taken",
    "description",
    "published",
    "author",
    "author_id",
    "tags"
})
public class Item implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 579380020399545437L;
	@JsonProperty("title")
    private String title;
    @JsonProperty("link")
    private String link;
    @JsonProperty("media")
    @Valid
    private Media media;
    @JsonProperty("date_taken")
    private String dateTaken;
    @JsonProperty("description")
    private String description;
    @JsonProperty("published")
    private String published;
    @JsonProperty("author")
    private String author;
    @JsonProperty("author_id")
    private String authorId;
    @JsonProperty("tags")
    private String tags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param tags
     * @param author
     * @param dateTaken
     * @param title
     * @param description
     * @param link
     * @param published
     * @param media
     * @param authorId
     */
    public Item(String title, String link, Media media, String dateTaken, String description, String published, String author, String authorId, String tags) {
        this.title = title;
        this.link = link;
        this.media = media;
        this.dateTaken = dateTaken;
        this.description = description;
        this.published = published;
        this.author = author;
        this.authorId = authorId;
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The media
     */
    @JsonProperty("media")
    public Media getMedia() {
        return media;
    }

    /**
     * 
     * @param media
     *     The media
     */
    @JsonProperty("media")
    public void setMedia(Media media) {
        this.media = media;
    }

    /**
     * 
     * @return
     *     The dateTaken
     */
    @JsonProperty("date_taken")
    public String getDateTaken() {
        return dateTaken;
    }

    /**
     * 
     * @param dateTaken
     *     The date_taken
     */
    @JsonProperty("date_taken")
    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The published
     */
    @JsonProperty("published")
    public String getPublished() {
        return published;
    }

    /**
     * 
     * @param published
     *     The published
     */
    @JsonProperty("published")
    public void setPublished(String published) {
        this.published = published;
    }

    /**
     * 
     * @return
     *     The author
     */
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The authorId
     */
    @JsonProperty("author_id")
    public String getAuthorId() {
        return authorId;
    }

    /**
     * 
     * @param authorId
     *     The author_id
     */
    @JsonProperty("author_id")
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * 
     * @return
     *     The tags
     */
    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
