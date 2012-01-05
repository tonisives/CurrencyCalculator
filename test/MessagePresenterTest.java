import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cannedapps.cachat.app.CaChatApplication;
import com.cannedapps.cachat.app.presenters.ChatPresenter;
import com.cannedapps.cachat.app.views.ChatView;

import com.xtremelabs.robolectric.RobolectricTestRunner;

import fakes.TestingMessageView;

@RunWith(RobolectricTestRunner.class)
public class MessagePresenterTest {
  CaChatApplication mApp;
  private ChatView activity;

  @Before
  public void setUp() throws Exception {
    activity = new ChatView();
    activity.onCreate(null);
    mApp = (CaChatApplication) activity.getApplication();
  }

  @Test
  public void testFirst() {
    TestingMessageView view = new TestingMessageView();
    ChatPresenter presenter = new ChatPresenter(view, mApp);

    presenter.addMessage("hello"); // << This is the method we want to test

    assertThat(view.lastMessage, equalTo("hello\n"));
  }
}
