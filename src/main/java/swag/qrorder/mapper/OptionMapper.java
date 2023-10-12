package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Option;
import swag.qrorder.model.OptionValue;

import java.util.List;

@Mapper
public interface OptionMapper {
    Integer addOptions(List<Option> options);
    Integer addOptionValues(List<OptionValue> values);
}
