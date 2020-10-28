package br.usjt.domain.interactors;

import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.usjt.domain.contracts.Hash;
import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.domain.entity.User;
import br.usjt.domain.interactor.UserInteractors;

public class UserInteractorTest {

    UserInteractors interactor;
    UserRepository repository;
    Hash hashDriver;

    @Before
    public void start() {
        this.repository = EasyMock.createMock(UserRepository.class);
        this.hashDriver = EasyMock.createMock(Hash.class);
        this.interactor = new UserInteractors(this.repository, this.hashDriver);
    }

    @Test
    public void shouldCreateUser() {
        EasyMock.expect(this.hashDriver.hash("any_password")).andReturn("any_password_hashed");
        this.interactor.create("Pelé", "any_password");
        EasyMock.expectLastCall().times(2);
    }
}
