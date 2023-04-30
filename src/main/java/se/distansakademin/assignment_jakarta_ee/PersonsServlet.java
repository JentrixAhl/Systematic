package se.distansakademin.assignment_jakarta_ee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.distansakademin.models.Person;
import se.distansakademin.repositories.PersonsRepository;

import java.io.IOException;

@WebServlet(name="PersonsServlet", urlPatterns = {"/persons"})
public class PersonsServlet extends HttpServlet{
    private final PersonsRepository repository = new PersonsRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String firstName = request.getParameter("firstName");
            String yearOfBirth = request.getParameter("yearOfBirth");

            var action = request.getParameter("action");
            action = (action == null) ? "create" : action;

            var person = new Person(firstName, yearOfBirth);


        switch (action) {
            case "create":
                repository.insert(person);
                break;
            case "update": {

                var idString = request.getParameter("id");
                var id = Long.parseLong(idString);
                person.setId(id);

                repository.update(person);
                break;
            }
            case "delete": {

                var idString = request.getParameter("id");
                var id = Long.parseLong(idString);

                repository.delete(id);
                break;
            }
        }


            response.sendRedirect(request.getContextPath() + "/persons");
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            var action = request.getParameter("action");
            action = (action == null) ? "index" : action;

            if (action.equals("create")){
                showCreatePersonForm(request, response);
            }
            else if(action.equals("update")){
                showUpdatePersonForm(request, response);
            }
            else{
                listPersons(request, response);
            }

        }

        private void listPersons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            var persons = repository.getAllPersons();
            request.setAttribute("persons", persons);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Persons/index.jsp");

            dispatcher.forward(request, response);
        }

        private void showCreatePersonForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Persons/create.jsp");

            dispatcher.forward(request, response);
        }

        private void showUpdatePersonForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            var idString = request.getParameter("id");

            var id = Long.parseLong(idString);

            var person = repository.getPersonById(id);

            request.setAttribute("person", person);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Persons/update.jsp");

            dispatcher.forward(request, response);
        }

}
