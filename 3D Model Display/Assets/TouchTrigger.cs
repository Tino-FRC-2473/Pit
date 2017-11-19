using UnityEngine;

public class TouchTrigger : MonoBehaviour
{
    public GameObject partWindow;
    float elapsedTime = 0f;
    // Update is called once per frame
    void Update()
    {
        if (Input.touchCount == 1)
        {
            Touch finger = Input.GetTouch(0);
            if (finger.deltaPosition.magnitude == 0)
            {
                elapsedTime += finger.deltaTime;
                if (elapsedTime > 0.5)
                {
                    Ray ray = Camera.main.ScreenPointToRay(finger.position);
                    RaycastHit hit;
                    if (Physics.Raycast(ray, out hit, Mathf.Infinity))
                    {
                        if (hit.transform.tag.Equals("Model"))
                        {
                            partWindow.SetActive(true);
                        }
                    }
                }
            }
        }

        if (Input.touchCount == 0)
        {
            elapsedTime = 0f;
        }
    }
}
