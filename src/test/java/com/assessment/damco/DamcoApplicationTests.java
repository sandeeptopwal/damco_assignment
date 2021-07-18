package com.assessment.damco;

//import org.junit.jupiter.api.Test;
import com.assessment.damco.api.controller.UserController;
import com.assessment.damco.api.model.UserModel;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class DamcoApplicationTests {

	private static final String API_PATH ="/user/";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserController userController;

	@Test
	public void whenSendRequestToGetResource_thenOK() throws Exception {
		UserModel userModel = new UserModel();
		userModel.setFirstname("Sandeep");
		userModel.setId("abcd");

		BDDMockito.given(userController.getUserData(userModel.getId())).willReturn(new ResponseEntity<>(userModel, HttpStatus.OK));

		mvc.perform(get(API_PATH + userModel.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstname", Matchers.is(userModel.getFirstname())));
	}

	@Test
	public void whenSendRequestToGetAllResource_thenOK() throws Exception {

		List<UserModel> list = prepareListUserModel();

		BDDMockito.given(userController.getAllUserData()).willReturn(new ResponseEntity<>(list, HttpStatus.OK));

		mvc.perform(get(API_PATH)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstname", Matchers.is(list.get(0).getFirstname())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].firstname", Matchers.is(list.get(1).getFirstname())));
	}

	@Test
	public void whenSendRequestToDeleteResource_thenOK() throws Exception {

		UserModel userModel = prepareUserModel("4fg","John");

		BDDMockito.given(userController.deleteUserData(userModel.getId())).willReturn(new ResponseEntity<>(true, HttpStatus.OK));

		mvc.perform(get(API_PATH)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	private List<UserModel> prepareListUserModel(){

		List<UserModel> userModelList = new ArrayList<>();
		userModelList.add(prepareUserModel("2ef","John"));
		userModelList.add(prepareUserModel("2efdf","Damco"));

		return userModelList;
	}

	private UserModel prepareUserModel(String id, String firstname){
		UserModel userModel= new UserModel();
		userModel.setId(id);
		userModel.setFirstname(firstname);
		return userModel;
	}

}
