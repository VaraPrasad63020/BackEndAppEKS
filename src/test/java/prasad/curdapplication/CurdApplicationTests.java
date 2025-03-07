package prasad.curdapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import prasad.curdapplication.Entity.Course;
import prasad.curdapplication.Repo.CourseRepo;
import prasad.curdapplication.Service.CourseServiceImpl;


@SpringBootTest
class CurdApplicationTests {
	@Autowired
	private CourseServiceImpl courseServiceImplementation;
	@MockBean
	private CourseRepo courseRepo;
	@Test
	void contextLoads() {
	}
@Test
	public void testGetAllCourses() {
		when(courseRepo.findAll()).thenReturn(Stream.of(new Course(1L, "Java", 10000.0f, "3 months")).collect(Collectors.toList()));
		assertEquals(1, courseServiceImplementation.getAllcourse().size());
	}
	@Test
	public void testGetCourseById() {
		Long id = 1L;
		Course course = new Course(1L, "Java", 10000.0f, "3 months");
		when(courseRepo.findById(id)).thenReturn(java.util.Optional.of(course));
		assertEquals(course, courseServiceImplementation.getCourseById(id));
	}
	@Test
	public void testSaveCourse() {
		Course course = new Course(1L, "Java", 10000.0f, "3 months");
		when(courseRepo.save(course)).thenReturn(course);
		assertEquals(course, courseServiceImplementation.upsert(course));
	}
	@Test
	public void testDeleteCourse() {
		Long id = 1L;
		Course course = new Course(1L, "Java", 10000.0f, "3 months");
		when(courseRepo.findById(id)).thenReturn(java.util.Optional.of(course));
		assertEquals("The id is not found", courseServiceImplementation.deleteCourse(id));
	}
}
