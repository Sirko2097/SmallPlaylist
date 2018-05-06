<%@ page import="model.Track" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sirko
  Date: 05.05.18
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Playlist</title>
</head>
<body>
    <div>
        <%
            List<Track> tracks = (List<Track>) request.getAttribute("playlist");
            if (tracks != null && !tracks.isEmpty()) {
                for (Track track :
                        tracks) {
                    out.println(track.getPerformer() + '\t' + track.getName() + '\t'
                    + track.getDuration() + '\t' + track.getGenre() + "<br>");
                }
            } else {
                out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                        +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <h5>There are no tracks yet!</h5>\n" +
                        "</div>");
            }
        %>
    </div>
</body>
</html>
