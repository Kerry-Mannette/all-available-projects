using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Cars
{
    public class AvailabilityModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesCarsContext _context;

       private readonly RazorPagesRental.Data.RazorPagesRentalsContext __context;
        public AvailabilityModel(RazorPagesRental.Data.RazorPagesCarsContext context, RazorPagesRental.Data.RazorPagesRentalsContext contexts)
        {
            _context = context;
            __context = contexts;
        }

        public IList<Cars> Cars { get;set; } = default!;

         public IList<Rentals> Rentals { get;set; } = default!;


        [BindProperty(SupportsGet = true)]
        public string? SearchString { get; set; }
         

        public async Task OnGetAsync()
        
        {

           var cars = from m in _context.Cars
                 select m;
            if (!string.IsNullOrEmpty(SearchString))
            {
                cars = cars.Where(s => s.Brand.Contains(SearchString));
            }

            Cars = await cars.ToListAsync();
            Rentals = await __context.Rentals.ToListAsync();



            
        }
    }
}
