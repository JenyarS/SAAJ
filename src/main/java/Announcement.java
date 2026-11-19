
import java.time.LocalDateTime;

/**
 * Represents an announcement published by a university club.
 * Related requirement: US-06.
 */
public class Announcement {

  // Attributes
  private final int announcementId;
  private final int clubId;
  private String title;
  private String body;
  private final LocalDateTime createdAt;

  /**
   * Creates a new club announcement.
   */
  public Announcement(int announcementId, int clubId,
      String title, String body) {

    if (announcementId <= 0 || clubId <= 0) {
      throw new IllegalArgumentException(
          "IDs must be positive.");
    }

    validateContent(title, body);

    this.announcementId = announcementId;
    this.clubId = clubId;
    this.title = title;
    this.body = body;
    this.createdAt = LocalDateTime.now();
  }

  /**
   * Returns the announcement ID.
   */
  public int getAnnouncementId() {
    return announcementId;
  }

  /**
   * Returns the club ID.
   */
  public int getClubId() {
    return clubId;
  }

  /**
   * Returns the announcement title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the announcement body.
   */
  public String getBody() {
    return body;
  }

  /**
   * Returns the announcement creation date.
   */
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Updates the title and body of an announcement.
   */
  public void updateContent(String newTitle,
      String newBody) {

    validateContent(newTitle, newBody);

    this.title = newTitle;
    this.body = newBody;
  }

  /**
   * Checks that the title and body are not empty.
   */
  private void validateContent(String title, String body) {

    if (title == null || title.isBlank()
        || body == null || body.isBlank()) {

      throw new IllegalArgumentException(
          "Title and body cannot be empty.");
    }
  }
}
