package ru.infoza.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("1value1", "1value2", "1value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return List.of(
                new SomeBean("1value1", "1value2", "1value3"),
                new SomeBean("2value1", "2value2", "2value3")
        );
    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue filteringDynamic() {
        SomeBean someBean = new SomeBean("1value1", "1value2", "1value3");
        MappingJacksonValue value = new MappingJacksonValue(someBean);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        value.setFilters(filters);
        return value;
    }

    @GetMapping("/filtering-dynamic-list")
    public MappingJacksonValue filteringDynamicList() {
        List<SomeBean> someBeans = List.of(
                new SomeBean("1value1", "1value2", "1value3"),
                new SomeBean("2value1", "2value2", "2value3")
        );
        MappingJacksonValue value = new MappingJacksonValue(someBeans);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        value.setFilters(filters);
        return value;
    }

}
