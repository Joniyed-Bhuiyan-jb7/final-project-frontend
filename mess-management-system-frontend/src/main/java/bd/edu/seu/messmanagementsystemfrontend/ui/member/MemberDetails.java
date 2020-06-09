package bd.edu.seu.messmanagementsystemfrontend.ui.member;import bd.edu.seu.messmanagementsystemfrontend.ui.Footer;import com.vaadin.flow.component.html.Div;import com.vaadin.flow.component.html.Label;import com.vaadin.flow.component.notification.Notification;import com.vaadin.flow.component.orderedlayout.VerticalLayout;import com.vaadin.flow.router.Route;import javax.servlet.http.HttpSession;@Route("memberDetails")public class MemberDetails extends VerticalLayout {    public MemberDetails(HttpSession httpSession){        super();        MemberHeader memberHeader = new MemberHeader(httpSession);        memberHeader.addAttachListener(attachEvent -> {            String userRole =(String) httpSession.getAttribute("user");            if(userRole==null) userRole="unknown";            Notification.show(userRole);            if(!userRole.equals("Member") && !userRole.equals("Admin")&&!userRole.equals("Manager")){                httpSession.removeAttribute("user");                memberHeader.getUI().ifPresent(ui -> ui.navigate("login"));            }        });        Div body = new Div();        body.setSizeFull();        body.add(new Label(" Member Details : "));        Footer footer = new Footer();        add(memberHeader,body,footer);    }}