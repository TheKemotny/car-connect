package pl.sda.carconnect.mapper;

public interface IMapper<E, D> {
    D fromEntityToDto(E entity);
    E fromDtoToEntity(D dto);
}
