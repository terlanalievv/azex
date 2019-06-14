select id, name from flexible_list
where status = 1 and id = 1;

select * from flexible_list_item;

select fli.id, fli.value_id, fli.value_name, fli.insert_date
from flexible_list_item fli join flexible_list fl on fli.list_id = fl.id and fli.status = 1 and fl.status = 1
where fl.id = 1
order by id;