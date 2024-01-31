# Тестовое задание. ЦФТ
## Описание задачи
#### Реализовать Android-приложение со следующими функциями:
1. #### Выводится краткая информация о пользователях (ФИО, фотография, адрес, номер телефона) в виде списка, полученная от https://randomuser.me ;
2. #### По клику на элемент списка на отдельном экране показывается полная информация о выбранном пользователе;
3. #### Данные о пользователях не теряются при перезапуске приложения;
4. #### Нажатие на Email, номер телефона, адрес/координаты отправляет пользователя в приложение, которое может обработать эти данные (почта, звонилка, карты);
5. #### Список пользователей можно обновить принудительно;
6. #### Пользователю выводятся уведомления о возникших ошибках при загрузке данных или работе с ними.
______________
### Стек технологий
+ #### Kotlin
+ #### Retrofit2 - взаимодействие с REST Api
+ #### Gson - конвертирование объектов JSON 
+ #### OkHttp - использование перехватчика ведения журнала
+ #### Coroutines - написание асинхронного кода
+ #### Flow - используется для передачи потока данных, которые могут быть вычислены асинхронно
+ #### Koin - внедрение зависимостей
+ #### Room - хранение данных локально 
+ #### LiveData - контейнер данных, поддерживающий подписку на изменения
+ #### ViewModel - сохранение данных, связанных с Ui
+ #### Navigation - навигация между фрагментами
+ #### Picasso - загрузка и отображение изображений 
