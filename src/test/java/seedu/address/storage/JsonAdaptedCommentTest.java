package seedu.address.storage;

import org.junit.jupiter.api.Test;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.fields.Comment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JsonAdaptedCommentTest {
    @Test
    public void get_Comment_Name_Test() {
        JsonAdaptedComment comment = new JsonAdaptedComment("test");
        assertEquals(comment.getCommentName(), "test");
    }

    @Test
    public void to_ModelType_Test() throws IllegalValueException {
        JsonAdaptedComment comment = new JsonAdaptedComment("test");
        Comment commentModel = comment.toModelType();
        assertEquals(commentModel.commentName, "test");
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Comment(null));
    }

    @Test
    public void constructor_invalidCommentName_throwsIllegalArgumentException() {
        String invalidCommentName = "";
        assertThrows(IllegalArgumentException.class, () -> new Comment(invalidCommentName));
    }

    @Test
    public void constructor_validCommentName() {
        Comment comment = new Comment("test");
        JsonAdaptedComment jsonAdaptedComment = new JsonAdaptedComment(comment);
        assertEquals(jsonAdaptedComment.getCommentName(), "test");
    }

    @Test
    public void toModelType_IlllegalValueException() {
        JsonAdaptedComment comment = new JsonAdaptedComment("");
        assertThrows(IllegalValueException.class, () -> comment.toModelType());
    }
}
