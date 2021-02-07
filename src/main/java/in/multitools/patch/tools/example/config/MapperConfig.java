package in.multitools.patch.tools.example.config;

import in.multitools.patch.tools.example.mapper.UserPatchMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import patch.tools.mapper.ChangeLoggerAnnotationIntrospector;
import patch.tools.mapper.PatchMapperProducer;

import java.util.List;

@Configuration
public class MapperConfig implements WebMvcConfigurer {

	private final PatchMapperProducer patchMapperProducer;

	public MapperConfig() {
		this.patchMapperProducer = new PatchMapperProducer();
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters
				.stream()
				.filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
				.forEach(
						converter -> ((MappingJackson2HttpMessageConverter) converter)
								.getObjectMapper().setAnnotationIntrospector(new ChangeLoggerAnnotationIntrospector())
				);
	}

	@Bean
	public UserPatchMapper userPatchMapper() {
		return patchMapperProducer.createMapper(UserPatchMapper.class);
	}
}
