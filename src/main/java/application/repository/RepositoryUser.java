package application.repository;

import application.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryUser
{
    private UserRepository repository;

    @Autowired
    public RepositoryUser(UserRepository repository)
    {
        this.repository = repository;
    }

    public List<UserModel> getAll()
    {
        return repository.findAll();
    }
    public UserModel getBy(Integer id)
    {
        return repository.getById(id);
    }
    public UserModel getByLogin(String login)
    {
        return repository.getByLogin(login);
    }
    public UserModel save(UserModel userModel)
    {
        repository.save(userModel);
        return userModel;
    }
    public UserModel update(String login , UserModel userModel)
    {
        userModel.setId(getByLogin(login).getId());
        repository.updateUser(userModel.getLogin() , userModel.getPassword() , login);
        return userModel;
    }
    public UserModel delete(String login)
    {
        repository.deleteUser(login);
        return new UserModel(null , login , null);
    }
}
