# Designing REST API as from a Class

1. A class correspond to one class
2. Each endpoint in a collection should be one method
3. Request parameters, query strings and body will be arguments
4. Return type will be the return
5. Error should be standard


```
class Socks {
    private ArrayList<Sock> socks;

    Socks() {
        this.socks  = new ArrayList<>();
    }

    // GET /socks?skip
    public ArrayList<Sock> getSocks();

    // POST /socks
    public void postSock(Sock sock);

    // PUT /socks
    public void putSock(Sock sock);

    // GET /socks/{id: int}
    public Sock getSock(int id); 

    // DELETE /socks/{id: int}
    public void deleteSock(int id);
}
```